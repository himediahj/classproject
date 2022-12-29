import React from "react";

// 상위 컴포넌트에서 데이터를 전달받아서 출력
function Details({menu}){
    if(!menu){   // 객체가 있으면 true, 없으면 false
        return(
            <div>선택된 메뉴가 없습니다.</div>
        )
    }

    return (
        <div>
            <h3>상품 번호 : {menu.mno}</h3>
            <h3>상품 이름 : {menu.name}</h3>
            <h3>상품 가격 : {menu.price}</h3>
        </div>
    )
}

export default Details