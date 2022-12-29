import React from 'react';

function Aside({category, recent}) {

    const list = category.map((item, index) => {
        return (
            <li key={index}>
                {item}
            </li>
        )
    })

    const list2 = recent.map((item, index) => {
        return (
            <li key={index}>
                {item}
            </li>
        )
    })

    return (
        <>
            <h4>카테고리</h4>
            <ul>{list}</ul>
            <h4>최근 글</h4>
            <ul>{list2}</ul>
        </>
    );
}

export default Aside;