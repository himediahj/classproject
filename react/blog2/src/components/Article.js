import React from 'react';
import png from './img/html5.png';

function Article({title, date, content}){
    return(
        <>
            <article>
                <h2>{title}</h2>
                <p>{date}</p>
                <img src={png}/>
                <p className="lh-180">{content}</p>
            </article>
        </>
    )}

export default Article;