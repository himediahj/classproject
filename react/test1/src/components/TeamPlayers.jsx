import React from "react";

const players = [{id: 1, name: '손흥민'}, {id:2, name: '이강인'}, {id:3, name: '조규성'}, {id:4, name: '황희찬'}]

function TeamPlayers(props){
    return(
        <ul>
            {players.map((player, index) => {
                return <li key={player.id}>{player.name}</li>
            })}
        </ul>
    )
}

export default TeamPlayers;