import React from 'react';
import Search from "./Search";

function Nav({nav}) {

    const list = nav.map((item, index) => {
        return (
            <li key={index}>
                {item}
            </li>
        )
    })

    return (
        <nav>
            <ul>
                {list}
            </ul>
            <Search/>
        </nav>
    )
}

export default Nav;