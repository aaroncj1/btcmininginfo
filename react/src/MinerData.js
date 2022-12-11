//import { useEffect, useState } from "react";

export default function MinerData (props) {
    //const [{hashrate, hashPriceDollars, hashPriceSats, bitcoinPrice}, setProfitData] = useState("");

    return (
        <div className="MinerData">
            <h2>
                Mining Profitability Results
            </h2>
            <p>
                Revenue in Dollars = {props.revenueDollars}
            </p>
            <p>
                Revenue in Sats = {props.revenueSats}
            </p>
            <p>
                Electrical Cost = {props.electricCost}
            </p>
            <p>
                Profit in dollars = {props.profitDollars}
            </p>
            <p>
                Profit in sats = {props.profitSats}
            </p>

        </div>
    )
}
