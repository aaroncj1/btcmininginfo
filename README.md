# btcmininginfo
SpringBoot API that calculates and returns current Bitcoin Mining Information

##Endpoints
###HTTP GET Method /bitcoin
This endpoint will return current bitcoin mining details. Including Price, current Hashrate, hashprice per Terahash in Dollars and in Satoshis

Sample Response:

    {
    "bitcoinPrice": "46988.47",
    "hashrate": "169220506205",
    "hashPriceDollars": "0.252308",
    "hashPriceSats": "536.96"
    }

###HTTP POST Method /bitcoin
This same uri endpoint will take your miner details in the request and respond with your current revenue and profitability in Dollars and Satoshis

Sample Request Body :

    {
    "pricePerKWH": ".12",
    "terahash": "200",
    "totalWattage": "6000",
    "days": "30"
    }

Sample Response Body:

    {
    "revenueSats": "3170598.531",
    "revenueDollars": "1489.986",
    "electricCost": "518.4000000000001",
    "profitSats": "2067475.227",
    "profitDollars": "971.586"
    }

### Code Style Guide 
I am using google style guide for this project. You can import the style schema from their repo here: https://github.com/google/styleguide