export default function MinerData (props) {

    return (
        <div className="MinerData">
            <h2>
                Mining Profitability Results
            </h2>
            <p>
                Revenue in Dollars = {props.data.revenueDollars}
            </p>
            <p>
                Revenue in Sats = {props.data.revenueSats}
            </p>
            <p>
                Electrical Cost = {props.data.electricCost}
            </p>
            <p>
                Profit in dollars = {props.data.profitDollars}
            </p>
            <p>
                Profit in sats = {props.data.profitSats}
            </p>

        </div>
    )
}
