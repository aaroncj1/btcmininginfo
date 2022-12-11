import { useEffect, useState } from "react";

export default function EconomicsData () {
    const [{hashrate, hashPriceDollars, hashPriceSats, bitcoinPrice}, setProfitData] = useState("");

    useEffect(() => {
        requestProfitData();
      }, []);
    
    async function requestProfitData() {
        const res = await fetch(
          `http://localhost:8081/profitability`
        );
        const json = await res.json();
        setProfitData(json);
    }

    return (
        <div className="ProfitData">
            <h2>
                Current Mining Economic Data
            </h2>
            <p>
                Total Network Hashrate = {hashrate}
            </p>
            <p>
                Bitcoin Price = ${bitcoinPrice}
            </p>
            <p>
                Hashprice in Sats = {hashPriceSats}
            </p>
            <p>
                Hashprice in Dollars = ${hashPriceDollars}
            </p>
        </div>
    )
}
