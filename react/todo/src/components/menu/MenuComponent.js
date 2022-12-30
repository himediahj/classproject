import React from 'react';
import {Dashboard} from "@mui/icons-material";
import ReorderIcon from '@mui/icons-material/Reorder';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import LoginIcon from '@mui/icons-material/Login';
import List from "@mui/material/List";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";

const menuArr = [
    {icon:<ReorderIcon/>, text: 'Todo List'},
    {icon:<AddCircleIcon/>, text: 'Todo 등록'},
    {icon:<LoginIcon/>, text: '로그인'},
    {icon:<Dashboard/>, text: '회원가입'}
]

function MenuComponent(props) {
    return (
        <List>
            {menuArr.map((menu, index) => {
                return(
                    <ListItemButton key={index}>
                        <ListItemIcon>{menu.icon}</ListItemIcon>
                        <ListItemText primary={menu.text}/>
                    </ListItemButton>
                )
            })}
        </List>
    );
}

export default MenuComponent;