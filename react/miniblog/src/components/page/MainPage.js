import React from 'react';
import styled from "styled-components";
import Button from "../ui/Button";
import {useNavigate} from "react-router-dom";
import PostList from "../list/PostList";
import data from "../../data.json"
import PageLayout from "./PageLayout";



function MainPage(props) {

    const navigate = useNavigate()

    return (
        <PageLayout>
            <Button title={'새 글'} onClick={() => navigate('/post-write')}/>
            <PostList posts={data} onClickItem={(item) => navigate(`/post/${item.id}`)}/>
        </PageLayout>
    );
}

export default MainPage;