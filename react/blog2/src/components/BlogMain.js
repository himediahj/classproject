import React from 'react';
import Header from "./Header";
import Nav from "./Nav";
import Wrap from "./Wrap";

const header = {title: 'hj\'s blog', description: '리액트를 공부하는 블로그'}

const nav = ['HTML5', 'CSS3', 'Java Script']



function BlogMain(props) {
    return (
        <div>
            <Header header={header}/>
            <Nav nav={nav}/>
            <Wrap/>
            <footer>Create by hj</footer>
        </div>
    );
}

export default BlogMain;