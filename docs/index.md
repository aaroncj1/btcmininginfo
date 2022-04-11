---
layout: default
---

## Endpoints
### HTTP GET Method /profitability
This endpoint will return bitcoin mining profitability details per terahash unit. Response include current bitcoin price, current Hashrate, hashprice per Terahash in Dollars and in Satoshis

Sample Response:

```json
    {
    "bitcoinPrice": "46988.47",
    "hashrate": "169220506205",
    "hashPriceDollars": "0.252308",
    "hashPriceSats": "536.96"
    }
```

### HTTP POST Method /profitability
Making a POST call on the same uri endpoint with your mining details in the request will respond with the current revenue and profitability in Dollars and Satoshis specific to your mining situation.

Sample Request Body :

```json
    {
    "pricePerKWH": ".12",
    "terahash": "200",
    "totalWattage": "6000",
    "days": "30"
    }
```

Sample Response Body:

```json
    {
    "revenueSats": "3170598.531",
    "revenueDollars": "1489.986",
    "electricCost": "518.4000000000001",
    "profitSats": "2067475.227",
    "profitDollars": "971.586"
    }
```

## Code Style Guide 
I am using google style guide for this project. You can download the style xml file from here: https://github.com/google/styleguide

## Testing

This api was built using Test Driven Development and has 100% unit test coverage.

In addition, there are 2 integration tests to test that each of the external REST calls are successful.

## Future Features

### SlushPool API

Adding support for the Slushpool pool and miner stats is a feature to be added

### Average Block Reward 

Calculate the average block reward, currently it is set as a constant value. 

