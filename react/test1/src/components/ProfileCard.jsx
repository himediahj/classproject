import React from "react";
import Card from "./Card";

function ProfileCard(props){
    return(
        <Card title='손흥민' backgroundcolor='yellow'>
            <p>안녕하세요! 손흥민입니다.</p>
            <p>저는 축구선수입니다.</p>
        </Card>
    )
}

export default ProfileCard