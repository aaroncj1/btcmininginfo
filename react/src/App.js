import { useState } from "react";
import './App.css';
import MinerParams from './MinerParams';
import EconomicsData from './EconomicsData';
import MinerData from "./MinerData";

function App() {
  const [data, setData] = useState('');
  
  const childToParent = (childdata) => {
    setData(childdata);
  }


  return (
    <div className="App">
      <header className="App-header">
        <h1>
          Bitcoin Mining Information
        </h1>
      </header>
      <div className='databox'>
        <EconomicsData />
        <MinerParams childToParent={childToParent} />
        <MinerData data={data}/>
      </div>
      <br/>
      <a
        className="App-link"
        href="https://aaroncj1.github.io/btcmininginfo/"
        target="_blank"
        rel="noopener noreferrer"
      >
        View Github Page
      </a>
    </div>
  );
}

export default App;
