<template>
  <div class="container">
    <div>
      <form @submit.prevent="submitForm">
        <input type="number" v-model="quantity" placeholder="Enter quantity">
        <button type="submit">Generate</button>
      </form>
    </div>
    <div>
      <form @submit.prevent="filterForm">
        <input type="number" v-model="price" placeholder="Enter price to filter">
        <input type="text" v-model="color" placeholder="Enter color to filter">
        <input type="text" v-model="type" placeholder="Enter type to filter">
        <button type="submit">Filter</button>
      </form>
    </div>
    <table class="table table-striped" v-if="displayedCars.length">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Brand</th>
          <th scope="col">Year</th>
          <th scope="col">Color</th>
          <th scope="col">Price</th>
          <th scope="col">Turbo</th>
          <th scope="col">Type</th>
          <th scope="col">Motor</th>
          <th scope="col">Popularity</th>
          <th scope="col">Cabinas</th>
          <th scope="col">Sunroof</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="car in displayedCars" :key="car.id">
          <td>{{car.id}}</td>
          <td>{{car.brand}}</td>
          <td>{{car.year}}</td>
          <td>{{car.color}}</td>
          <td>{{car.price}}</td>
          <td>{{car.turbo}}</td>
          <td>{{car.type}}</td>
          <td>{{car.motor}}</td>
          <td>{{car.popularity}}</td>
          <td>{{car.cabinas}}</td>
          <td>{{car.sunroof}}</td>
        </tr>
      </tbody>
    </table>
    <p v-else>No cars available.</p>
  </div>
</template>

<script>
//import { reactive } from 'vue';
import axios from 'axios';
  
export default {
  data(){
    return{
      quantity: 0,
      price: null,
      color: null,
      type: null,
      filteredCars: null,
      cars: null,
    };
  },
  computed:{
    displayedCars(){
      if(this.filteredCars && this.filteredCars.length > 0){
        return this.filteredCars;
      }else if(this.cars && this.cars.length > 0){
        return this.cars;
      }else{
        return [];
      }
    }
  },
  methods:{
    generate(){
      axios.get(`http://localhost:3001/api/generate?quantity=${this.quantity}`)
        .then(response => {
          this.cars = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    filter(){
      let requestBase = `http://localhost:3001/api/list`;
      let request = `?`;

      if(this.price){
        request += `&price=${this.price}`
      }
      if(this.color){
        request += `&color=${this.color}`
      }
      if(this.type){
        request += `&type=${this.type}`
      }
      axios.get(requestBase+request)
        .then(response => {
          this.filteredCars = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    submitForm(){
      if(this.quantity>0){
        this.generate();
      }
    },
    filterForm(){
      this.filteredCars = null;

      if(this.price || this.color || this.type){
        this.filter();
      }else{
        this.filteredCars = this.cars;
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
