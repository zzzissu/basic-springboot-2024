// import { useState } from "react";

function IncButton({count, onClick}) {
    // const [count, setCount] = useState(0);    // count = 변수, setCount = 변수값을 조정할 함수, useState(0) 최초 0 초기화
  
    // function upCilck() {
    //   setCount(count +1);
    // }
  
    return(
    //   <button onClick={upCilck} count={count}>
      <button onClick={onClick}>
        {count}번 증가!!
      </button>
    )
  }

  export default IncButton;