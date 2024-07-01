function CustomButton(props) {
    let isLoggedIn = true;     // 로그인 여부
    let content;
    let heroName = props.data.heroName;

    console.log(heroName);

    function handleClick(name) {
        if(isLoggedIn) {
            alert(name + "이(가) 로그아웃 되었습니다!");
        } else {
            alert(name + "이(가) 로그인 되었습니다.")
        }
    }

    // if(isLoggedIn) {
    //     content = <button>Log Out</button>;
    // } else {
    //     content = <button>Log In</button>;
    // }
    return (
        <>
            {/* {content} */}
            {
                isLoggedIn ? (
                    <button onClick={() => handleClick("아이언맨")}>Log Out</button>
                ) : (
                    <button onClick={() => handleClick("아이언맨")}>Log In</button>
                )
            }
        </>
    );
}

// function CustomButton() {
//     return (
//         <>
//             <button>MyButton</button>
//             <button>Second Button</button>
//         </>
//         // div로도 가능하지만 <>만으로도 가능
//     );
//   }

export default CustomButton;    // 외부에서 사용하려면 필수!