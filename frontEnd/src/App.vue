<template>
<div>
    <Header></Header>
    <router-view/>
    <Footer></Footer>
</div>
</template>

<script>
     import '@/assets/reset.css';
     import Header from '@/components/Header.vue';
     import Footer from '@/components/Footer.vue';

     export default {
       components: {
         Header,
         Footer
       }
     }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


</style>
