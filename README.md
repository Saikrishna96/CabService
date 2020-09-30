How to run this project?

  $ mvn spring-boot:run



How to test this project?

1. create user

	curl --location --request POST 'http://localhost:8080/user' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "id" : "u2",
	    "name": "sai2",
	    "email": "sai.krishna@niki.ai",
	    "location": {
	        "x" : 4,
	        "y" : 5
	    }
	}'  



2. create cab

	curl --location --request POST 'http://localhost:8080/cab' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "id": "c1",
	    "licensePlate": "KA04JB4891"
	}'


3. create driver

	curl --location --request POST 'http://localhost:8080/driver' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "id": "d1",
	    "name": "driver1",
	    "email": "driver1@gmail.com",
	    "cabId" : "c1",
	    "phoneNumber": "7777788888",
	    "location": {
	        "x" : 3,
	        "y" : 4
	    }
	}'


4. Book cab

	curl --location --request GET 'http://localhost:8080/book/user/u2?x=3&y=5'

5. End ride
	
	curl --location --request GET 'http://localhost:8080/book/driver/d1/endride?rideId=r_u2_d1&x=5&y=6'


6. Get all driver rides:

	curl --location --request GET 'http://localhost:8080/driver/d1/rides'

7. Get all user rides:

	curl --location --request GET 'http://localhost:8080/user/u2/rides'


8. Get total rides count: (ALL statuses)

	curl --location --request GET 'http://localhost:8080/book/total-rides'


