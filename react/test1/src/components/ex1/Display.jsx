import React from "react";

// 상위 컴포넌트에서 배열을 받아 리스트 출력
// 클릭 이벤트에 적용할 핸들러 받아서 적용
// [{mno:1, name: '상품1', price: 4000}, {}, {}...]
// changeMenu => 상품 번호를 받아서 선택 상품의 상태를 변경시키는 역할
function Display({arr, changeMenu}){
    return (
        <div>
            <ul>
                {arr.map(menu => <li key={menu.mno} onClick={()=> changeMenu(menu.mno)}>{menu.name}</li>)}
            </ul>
        </div>
    )
}

export default Display