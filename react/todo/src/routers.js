import {createBrowserRouter, Navigate} from "react-router-dom";
import MainPage from "./page/MainPage";
import AboutPage from "./page/AboutPage";
import TodoListPage from "./page/todo/TodoListPage";
import TodoRegisterPage from "./page/todo/TodoRegisterPage";
import TodoReadPage from "./page/todo/TodoReadPage";

const routers = createBrowserRouter([
    {
        path: '',
        element: <MainPage/>
    },
    {
        path: 'about',
        element: <AboutPage/>
    },
    {
        path: 'todo',
        children: [
            {
                path: 'list',
                element: <TodoListPage/>
            },
            {
                path: 'register',
                element: <TodoRegisterPage/>
            },
            {
                //  /todo 까지만 왔을 때 경로
                path: '',
                element: <Navigate to={'/todo/list'} replace={true}/>
            },
            {
                path: ':cmd/:id',
                element: <TodoReadPage/>
            }
        ]
    }
])

export default routers;