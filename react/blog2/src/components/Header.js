import React from 'react';

// {title: '', description: ''}
function Header({header}) {
    return (
        <div>
            <header>
                <h1 className="title">{header.title}</h1>
                <p>{header.description}</p>
            </header>
        </div>
    );
}

export default Header;