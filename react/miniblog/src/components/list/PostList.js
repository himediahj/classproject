import React from 'react';
import styled from "styled-components";
import PostListItem from "./PostListItem";

const Wrapper = styled.div`
    margin-top: 10px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    
    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }
`
// & => div 가리키는 거고 div 밑의 자식들 * 중에 last-child 아닌 애들

function PostList({posts, onClickItem}) {   // onClickItem은 라우트 (페이지 이동)
    return (
        <Wrapper>
            {posts.map(post => {
                return (
                    <PostListItem key={post.id} post={post} onClick={() => onClickItem(post)}></PostListItem>
                )
            })}
        </Wrapper>
    );
}

export default PostList;