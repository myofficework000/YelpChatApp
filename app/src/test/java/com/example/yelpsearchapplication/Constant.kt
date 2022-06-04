package com.example.yelpsearchapplication

object Constant {
    const val BUSINESS_LIST_RESPONSE = """{
  "total": 8228,
  "businesses": [
    {
      "rating": 4,
      "price": "${'$'}",
      "phone": "+14152520800",
      "id": "E8RJkjfdcwgtyoPMjQ_Olg",
      "alias": "four-barrel-coffee-san-francisco",
      "is_closed": false,
      "categories": [
        {
          "alias": "coffee",
          "title": "Coffee & Tea"
        }
      ],
      "review_count": 1738,
      "name": "Four Barrel Coffee",
      "url": "https://www.yelp.com/biz/four-barrel-coffee-san-francisco",
      "coordinates": {
        "latitude": 37.7670169511878,
        "longitude": -122.42184275
      },
      "image_url": "http://s3-media2.fl.yelpcdn.com/bphoto/MmgtASP3l_t4tPCL1iAsCg/o.jpg",
      "location": {
        "city": "San Francisco",
        "country": "US",
        "address2": "",
        "address3": "",
        "state": "CA",
        "address1": "375 Valencia St",
        "zip_code": "94103"
      },
      "distance": 1604.23,
      "transactions": ["pickup", "delivery"]
    }],
    "region": {
    "center": {
      "latitude": 37.767413217936834,
      "longitude": -122.42820739746094
    }
  }}"""

    const val BUSINESS_LIST_EMPTY_RESPONSE = """{
  "total": 0,
  "businesses": [],
  "region": {
    "center": {
      "latitude": 37.767413217936834,
      "longitude": -122.42820739746094
    }
    }
    }
  """

    const val BUSINESS_DETAILS_RESPONSE = """{
        "id": "MGzro82Fi4LYvc86acoONQ",
        "alias": "franklin-barbecue-austin",
        "name": "Franklin Barbecue",
        "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/xV3c8kwe-q10139Dh-Xc-g/o.jpg",
        "is_claimed": true,
        "is_closed": false,
        "url": "https://www.yelp.com/biz/franklin-barbecue-austin?adjust_creative=XeJjbYPxkGxge7A6LDr-WA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=XeJjbYPxkGxge7A6LDr-WA",
        "phone": "+15126531187",
        "display_phone": "(512) 653-1187",
        "review_count": 5306,
        "categories": [
        {
            "alias": "bbq",
            "title": "Barbeque"
        },
        {
            "alias": "breakfast_brunch",
            "title": "Breakfast & Brunch"
        },
        {
            "alias": "tacos",
            "title": "Tacos"
        }
        ],
        "rating": 4.5,
        "location": {
        "address1": "900 E 11th St",
        "address2": "",
        "address3": "",
        "city": "Austin",
        "zip_code": "78702",
        "country": "US",
        "state": "TX",
        "display_address": [
        "900 E 11th St",
        "Austin, TX 78702"
        ],
        "cross_streets": ""
    },
        "coordinates": {
        "latitude": 30.2701348,
        "longitude": -97.7313451068641
    },
        "photos": [
        "https://s3-media4.fl.yelpcdn.com/bphoto/xV3c8kwe-q10139Dh-Xc-g/o.jpg",
        "https://s3-media2.fl.yelpcdn.com/bphoto/3FO-3tcb8yUOwsAVws9MAA/o.jpg",
        "https://s3-media3.fl.yelpcdn.com/bphoto/SYK2-2p54WdbgOO9YYYNBA/o.jpg"
        ],
        "price": "$$",
        "hours": [
        {
            "open": [
            {
                "is_overnight": false,
                "start": "1100",
                "end": "1500",
                "day": 1
            },
            {
                "is_overnight": false,
                "start": "1100",
                "end": "1500",
                "day": 2
            },
            {
                "is_overnight": false,
                "start": "1100",
                "end": "1500",
                "day": 3
            },
            {
                "is_overnight": false,
                "start": "1100",
                "end": "1500",
                "day": 4
            },
            {
                "is_overnight": false,
                "start": "1100",
                "end": "1500",
                "day": 5
            },
            {
                "is_overnight": false,
                "start": "1100",
                "end": "1500",
                "day": 6
            }
            ],
            "hours_type": "REGULAR",
            "is_open_now": false
        }
        ],
        "transactions": [
        "delivery"
        ],
        "special_hours": [
        {
            "date": "2022-07-26",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-27",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-27",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-28",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-28",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-29",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-29",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-30",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-30",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-31",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-07-31",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-01",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-02",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-03",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-03",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-04",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-04",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-08-05",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-11-24",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-11-25",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-11-25",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-11-26",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-12-25",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-12-26",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-12-27",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        },
        {
            "date": "2022-12-28",
            "is_closed": true,
            "start": null,
            "end": null,
            "is_overnight": null
        }
        ]
    }"""

    const val BUSINESS_DETAILS_EMPTY_RESPONSE = """{
        "id": "MGzro82Fi4LYvc86acoONQ",
        "alias": "franklin-barbecue-austin",
        "name": "Franklin Barbecue",
        "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/xV3c8kwe-q10139Dh-Xc-g/o.jpg",
        "is_claimed": true,
        "is_closed": false,
        "url": "https://www.yelp.com/biz/franklin-barbecue-austin?adjust_creative=XeJjbYPxkGxge7A6LDr-WA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_lookup&utm_source=XeJjbYPxkGxge7A6LDr-WA",
        "phone": "+15126531187",
        "display_phone": "(512) 653-1187",
        "review_count": 5306,
        "categories": []}"""
}