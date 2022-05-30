# Courier Service Application

Courier Service Application is an application that delivers the packages and maintains the delivery record of the packages.


## Usage

```
mvn package
```
run the snapshot jar file in the generated directory target 
```
java -cp target/delivery-1.0-SNAPSHOT.jar CourierServiceApplication
```
# Offer codes 
calculated the discount based on these valid offer codes with the criteria of distance and weight

| Code          | discount.       | distance(km) | weight(km) |\
|:------------  |:---------------:| -----:   | -----: |\
| OFR001        | 10% | <200    |  70-200      |\
| OFR002        | 7%        |   5-150   |   100-250     |\
| OFR003        | 5%       |    50-250   |     10-150   |


# Delivery Criteria
Shipment should contain maximum packages the vehicle can carry on a trip  \
We should prefer heavier packages when multiple shipments have the same no. of packages.
If the weights are also the same, preference should be given to the shipment which can be delivered first. \
Vehicles always travel at maximum speed \
Post package delivery, with the same speed and will be available for another shipment. 


## Sample input and output format
input format
```
base_delivery_cost no_of_packges

pkg_id1 pkg_weight1_in_kg distance1_in_km offer_code1

….

no_of_vehicles max_speed max_carriable_weight
```

output format

```
pkg_id1 discount1 total_cost1 estimated_delivery_time1_in_hours
```

## Sample input and output

input
```
100 5
PKG1 50 30 OFR001
PKG2 75 125 OFFR0008
PKG3 175 100 OFFR003
PKG4 110 60 OFFR002
PKG5 155 95 NA
2 70 200
```
output
```
PKG1 0 750 3.98
PKG2 0 1475 1.78
PKG3 0 2350 1.42
PKG4 105 1395 0.85
PKG5 0 2125 4.19
```

# Dependencies
- lombok
- junit
- mockito