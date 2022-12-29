import React from "react";
import { useState } from "react";
import Details from "./Details";
import Display from "./Display";

// 컨트롤러 역할
// 하위 컴포넌트에 전달할 데이터, 상태값을 가지고 있다
// 상태값 변경해주는 핸들러 함수도 하위 컴포넌트에 전달!

const menus = [{mno:1, name:'상품1', price:4000}, {mno:2, name: '상품2', price:2000}, {mno:3, name:'상품3', price:3000}, {mno:4, name:'상품4', price:4000}]

const style = {
    wrapper: {padding: 20, display: 'flex', flexDirection: 'row', justifyContent: 'space-around'}
}

function Container(props){
    // 선택한(클릭) 메뉴를 속성으로 저장 => Detail로 데이터 전달
    // selectedMenu => {mno:1, name:'상품1', price:4000}
    const [selectedMenu, setSelectedMenu] = useState()

    const changeMenu = (mno) => {
        // 상품 번호로 배열에서 상품을 검색 => 해당 상품의 객체를 반환
        const menu = menus.find(menu => menu.mno === mno)

        // 속성으로 관리하는 선택 메뉴 값을 변경해줘야 (변경되어야 렌더링이 되니까)
        setSelectedMenu(menu)
    } 

    return(
        <div style={style.wrapper}>
            <Display arr={menus} changeMenu={changeMenu}/>
            <Details menu={selectedMenu}/>
        </div>
    )
}

export default Container