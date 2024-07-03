import axios from 'axios';

// Hook 함수 사용
import React, {userState, userEffect, useState, useEffect} from 'react';

// Navigation
import {Link} from 'react-router-dom'

// 공통함수 추가
import * as common from '../common/CommonFunc';

function BoardList() {  // 객체를 만드는 함수
    // 변수선언, return | render() html, react 태그에서 반복할 때 사용됨
    const [boardList, setBoardList] = useState([]); // 배결값을 받아서 상태를 저장하기 때문에 []
    const [pageList, setPageList] = useState([]);   // 페이징을 위한 배열데이터
    const [nextBlock, setNextBlock] = useState(0);  // 다음 블럭 값
    const [prevBlock, setPrevBlock] = useState(0);  // 이전 블럭 값
    const [lastPage, setLastPage] = useState(0);    // 마지막 페이지번호
    
    // 함수선언
    // 제일 중요!!
    const getBoardList = async (page) => {
        var pageString = (page == null) ? 'page=0': 'page=' + page;

        try {   // 백엔드 서버가 실행되지 않으면 예외발생 axios error
            const resp = (await axios.get("//localhost:8080/api/board/list/free?" + pageString));

            const resultCode = resp.data.resultCode;
            // console.log(resultCode);    // OK or ERROR

            if(resultCode == 'OK') {
                setBoardList(resp.data.data);     // boardList 변수에 담는 작업
                console.log(resp.data.data);
                
                const paging = resp.data.paging;    // 페이징 정보
                // console.log(paging);    // 개발이 완료되면 콘솔로그는 주석처리
                
                // getBoardList() 내에 있는 지역변수(위의 nextBlock과 다름)
                const { endPage, nextBlock, page, prevBlock, startPage, totalListSize, totalPageNum } = paging;
                // console.log(totalListSize);
                // console.log(totalPageNum);

                const tmpPages = [];
                for(let i = startPage; i <= endPage; i++) {
                    tmpPages.push(i);       // [1, 2, 3, 4, 5]

                }
                setPageList(tmpPages);
                setNextBlock(nextBlock);
                setPrevBlock(prevBlock);
                setLastPage(totalPageNum);  // 마지막 페이지 번호
                
            } else {
                alert("문제가 발생하였습니다.");
            }

        } catch(error) {
            console.log(">>>>>" + error);
            alert("서버가 연결되지 않았습니다.");
        }
    }

    function onPageClick(page) {
        console.log(page);
        getBoardList(page - 1);     // Spring Boot에서는 0부터 시작했기 때문에 -1
    }

    useEffect(() => {
        getBoardList();
    }, []);


    return (
        <div className="container">
            <table className='table table-striped'>
                <thead className='table-dark'>
                    <tr className='text-center'>
                        <th>번호</th>
                        <th style={{width:'50%'}}>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    {/* 반복으로 드어갈 부분 */}
                    {boardList.map((board) => (

                        <tr className='text-center' key={board.num}>
                            <td>{board.num}</td>
                            <td className='text-start'>
                                <Link to={`/boardDetail/${board.bno}`}>{board.title}</Link>
                                &nbsp;
                                {
                                    board.replyList != null &&
                                    <span class="badge text-bg-warning">{board.replyList.length}</span>
                                }
                            </td>
                            <td>{board.writer}</td>
                            <td>{board.hit}</td>
                            <td>{common.formatDate(board.createDate)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            {/* 페이징처리 */}
            <div className='d-flex justify-content-center'>
                <nav aria-label= 'Page navigation'>
                    <ul className='pagination'>
                        <li className='page-item'>
                            <button className='page-link' aria-label='first' onClick={() => onPageClick(1)}>
                                <span>&laquo;</span>
                            </button>
                        </li>
                        <li className='page-item'>
                            <button className='page-link' aria-label='previous' onClick={() => onPageClick(prevBlock)}>
                                <span>&lt;</span>
                            </button>
                        </li>
                        {pageList.map((page, index) => (
                            <li className='page-item' key={index}>
                                <button className='page-link'onClick={() => onPageClick(page)}>
                                    {page}
                                </button>
                            </li>
                        ))}
                        <li className='page-item'>
                            <button className='page-link' aria-label='next' onClick={() => onPageClick(nextBlock)}>
                                <span>&gt;</span>
                            </button>
                        </li>
                        <li className='page-item'>
                            <button className='page-link' aria-label='last' onClick={() => onPageClick(lastPage)}>
                                <span>&raquo;</span>
                            </button>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    );
}

export default BoardList;