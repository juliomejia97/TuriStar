<template>
  <div class="mybookings">
    <h1>My Bookings</h1>
    <div class="tourBookings">
            <TourBookingCard 
              v-for="tour in tourBookings"
              :key="tour.id"
              :initDate="tour.initDate"
              :endDate="tour.endDate"
              :tourId="tour.tourId"
            />
    </div>
  </div>
</template>

<script>
import { defineComponent } from 'vue'
import TourBookingCard from '../components/Tours/TourBookingCard'

export default defineComponent({
  name: "Bookings",
  components: {
    TourBookingCard,
  },
  data(){
    return {
      tourBookings:[ {
        id:"5ade9d58-ac73-11eb-8529-0242ac130006",
        initDate: "02/27/2021",
        endDate: "02/27/2021",
        tourId: "5ade9d58-ac73-11eb-8529-0242ac130006" 
        }
      ]
    }
  }
})
</script>


