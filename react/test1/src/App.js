import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';
import Notification from './components/Notification';
import Counter from './components/Counter';
import TextInputButton from './components/TextInputButton';
import Accomodate from './components/Accomodate';
import Toggle from './components/Toggle';
import MyButton from './components/MyButton';
import ConfirmButton from './components/ConfirmButton';
import Greeting from './components/Greeting';
import LoginControl from './components/LoginControl';
import MailBox from './components/MailBox';
import UserStatus from './components/UserStatus';
import WarningBanner from './components/WarningBanner';
import Mainpage from './components/Mainpage';

/* const comment = {
  user : {
    userName : '손흥민',
    imgUrl : 'https://flexible.img.hani.co.kr/flexible/normal/900/609/imgdb/original/2022/0918/20220918500360.jpg'
  },
  content : '대한민국 화이팅!',
  replydate : '2022-12-26'
}

function App() {
  return (
    <Comment user={comment.user} content={comment.content} replydate={comment.replydate}/>
  );
} */

/* function App(){
  return (
    <Notification message="안녕하세요"/>
  )
} */

/* function App(){
  return(
    <Counter/>
  )
} */

/* function App(){
  return (
    <TextInputButton/>
  )
} */

/* function App(){
  return (
    <Accomodate/>
  )
} */

/* function App(){
  return(
    <Toggle/>
  )
} */

/* function App(){
  return(
    <MyButton/>
  )
} */

/* function App(){
  return(
    <ConfirmButton/>
  )
} */

/* function App(){
  return(
    <Greeting isLogin={true}/>
  )
} */

/* function App(){
  return(
    <LoginControl/>
  )
} */

/* let list = [{}, {}, {}, {}, {}, {}, {}]

function App(){
  return(
    <MailBox unReadMessage={list}/>
  )
} */

/* function App(){
  return (
    <UserStatus isLogin={false}/>
  )
} */

/* function App(){
  return(
    <WarningBanner warning={true}/>
  )
} */

function App(){
  return(
    <Mainpage/>
  )
}

{/* <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React 1234
        </a>
      </header>
    </div> */}

export default App;
