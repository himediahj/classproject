import React from "react";
import { useCallback } from "react";
import { useState } from "react";
import MainContent from "./MainContent";
import ThemeContext from "./ThemeContext";

function DarkOrWhite(props){

    const [theme, setTheme] = useState('light')

    const toggleTheme = useCallback(() => {
        if(theme == 'light') setTheme('dark')
        else setTheme('light')
    }, [theme]) // theme가 바뀔 때 마다

    return (
        <ThemeContext.Provider value={{theme, toggleTheme}}>
            <MainContent/>
        </ThemeContext.Provider>
    )
}

export default DarkOrWhite