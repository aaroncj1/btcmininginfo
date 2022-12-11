import './App.css';
import MinerParams from './MinerParams';
import EconomicsData from './EconomicsData';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>
          Bitcoin Mining information
        </h1>
      </header>
      <div className='databox'>
      <EconomicsData />
      <MinerParams />
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
