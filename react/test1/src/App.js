import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';

const comment = {
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
