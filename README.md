# hair-salon-reservation-web
By this website,  a user can select a hair salon from the list of hair salons and reserve menu, stylist, date, and time zone for the hair salon. This website is made by Java/Spring Boot/MySQL/Materialize.




Database name: offtocol




Username: Sara

    --- Email Address: a@a.com

    --- Password: demo

    --- Role: USER


Username: HairSalon_A

    --- EmailAddress: b@a.com

    --- Password: demo

    --- Role: OWNER


Username: HairSalon_B

    --- Email Address: c@a.com

    --- Password: demo

    --- Role: OWNER


Username: HairSalon_C

    --- Email Address: d@a.com

    --- Password: demo

    --- Role: OWNER


Username: Offtocol

    --- Email Address: e@a.com

    --- Password: demo

    --- Role: ADMIN




src/main/java/offtocol


    --- app

        --- admin
            --- AdminController.java

        --- confirm
            --- ConfirmController.java
            --- InvalidCartException.java

        --- dashboard
            --- DashboardController.java
            --- DetailController.java

        --- finish
            --- FinishController.java

        --- goods
            --- GoodsController.java

        --- house
            --- HouseController.java

        --- index
            --- IndexController.java

        --- info
            --- InfoController.java

        --- login
            --- LoginController.java

        --- owner
            --- OwnerController.java

        --- reservation
            --- ReservationForm.java
            --- ReservationController.java

        --- room
            --- RoomController.java

        --- user
            --- UserController.java


   -- domain

        --- model

            --- converter
                --- LocalDateConverter.java
                --- LocalTimeConverter.java
                --- LocalDateTimeConverter.java

            --- Cart.java
            --- CartHouse.java
            --- CartItem.java
            --- CartRoomAndDate.java
            --- Goods.java
            --- House.java
            --- MeetingRoom.java
            --- ReservableRoom.java
            --- ReservableRoomId.java
            --- Reservation.java
            --- ReservationLine.java
            --- User.java

        --- repository

            --- goods
                --- GoodsRepository.java

            --- house
                --- HouseRepository.java

            --- reservation
                --- ReservationRepository.java

            --- reservationLine
                --- ReservationLineRepository.java

            --- room
                --- MeetingRoomRepository.java
                --- ReservabelRoomRepository.java

            --- user
                --- UserRepository.java


        --- service

            --- goods
                --- GoodsService.java

            --- house
                --- HouseService.java

            --- reservation
                --- AlreadyReservedException.java
                --- ReservationService.java
                --- UnavailableReservationException.java

            --- reservationLine
                --- ReservationLineService.java

            --- room
                --- MeetingRoomService.java
                --- ReservabelRoomService.java

            --- user
                --- ReservationUserDetails.java
                --- ReservationUserDetailsService.java
                --- SecurityService.java
                --- SecurityServiceImpl.java
                --- UserService.java
                --- UserServiceImpl.java
                --- UserValidator.java





   -- OfftocolApplication.java

   -- WebSecurityConfig.java



src/main/java/resources


    -- static

        --- css
            --- Style.css


    -- templetes

        --- admin
            --- admin.html

        --- dashboard
            --- dashboard.html
            --- menu.html

        --- goods
            --- listGoods.html

        --- house
            --- listHouses.html

        --- login
            --- LoginForm.html

        --- order
            --- confirm.html
            --- finish.html

        --- owner
            --- owner.html

        --- public
            --- index.html

        --- reservation
            --- reservationForm.html

        --- room
            --- listRooms.html

        --- users
            --- registerForm.html
            --- userInfo.html


    -- application.properties

    -- data.sql

    -- validation.properties




target
    -- pom.xml