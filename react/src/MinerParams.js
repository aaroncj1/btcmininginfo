import { useEffect, useState } from "react";
import MinerData from "./MinerData";

const MinerParams = () => {
    const [electricalRate, setElectricalRate] = useState("0.1");
    const [terahash, setTerahash] = useState("13.5");
    const [totalWattage, setTotalWattage] = useState("1300");
    const [days, setDays] = useState("30");
    const [ {revenueSats, revenueDollars, electricCost, profitSats, profitDollars}, setMiningResults] = useState("");

  useEffect(() => {
    requestMiningResults();
  }, []); // eslint-disable-line react-hooks/exhaustive-deps

  async function requestMiningResults() {
    const res = await fetch(
        `http://localhost:8081/profitability`, {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"pricePerKWH": electricalRate, terahash, totalWattage, days})
          });
    const json = await res.json();
    setMiningResults(json);
  }

  return (
    <div className="formbox">
      <form className="MinerData"
      onSubmit={(e) => {
          e.preventDefault();
          requestMiningResults();
        }}
        >
        <h2>Enter Mining Info</h2>
        <p>Popular Asics : 
            <br/>
        <button onClick={(e) => {
            e.preventDefault();
            setTotalWattage(1300);
            setTerahash(13.5);
        }}>S9</button>
        <button onClick={(e) => {
            e.preventDefault();
            setTotalWattage(3050);
            setTerahash(100);
        }}>S19</button>
        <button onClick={(e) => {
            e.preventDefault();
            setTotalWattage(3010);
            setTerahash(140);
        }}>S19 XP</button>
        <button onClick={(e) => {
            e.preventDefault();
            setTotalWattage(3472);
            setTerahash(112);
        }}>M30S++</button>
        <button onClick={(e) => {
            e.preventDefault();
            setTotalWattage(3276);
            setTerahash(126);
        }}>M50S</button>
</p>

        <label htmlFor="terahash" className="textbox">
        Terahash
        <input className=""
            id="terahash"
            value={terahash}
            placeholder="terahash"
            onChange={(e) => {
              setTerahash(e.target.value);
            }}
        />
        </label>
        <br/>

        <label htmlFor="totalWattage">
          Wattage
          <input
            id="totalWattage"
            value={totalWattage}
            placeholder="totalWattage"
            onChange={(e) => {
              setTotalWattage(e.target.value);
            }}
        />
        </label>
        <br />
        <label htmlFor="electricalRate">
          Electrical Rate
          <input
            id="electricalRate"
            value={electricalRate}
            placeholder="electricalRate"
            onChange={(e) => setElectricalRate(e.target.value)}
          />
        </label>
        <br/>

        <label htmlFor="days">
          Days
          <input
            id="days"
            value={days}
            placeholder="days"
            onChange={(e) => {
              setDays(e.target.value);
            }}
        />
        </label>
        <br/>

        <button>Submit</button>
        <br/>

      </form>
      <div className="MinerData">
      <MinerData revenueDollars={revenueDollars} revenueSats={revenueSats} electricCost={electricCost} profitDollars={profitDollars} profitSats={profitSats} />
      </div>
    </div>
  );
};

export default MinerParams;