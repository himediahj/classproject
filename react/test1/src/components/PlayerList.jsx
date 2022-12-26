import React from "react";
import Player from "./Player";

function Team(props){
    return (
        <div>
            <Player playerName='SON' playerNumber='7'></Player>
            <Player playerName='LEE' playerNumber='20'></Player>
            <Player playerName='Park' playerNumber='9'></Player>
        </div>
    )
}

export default Team;