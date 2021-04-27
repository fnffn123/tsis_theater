
<template>
  <div id="app">
    <router-link to="/">[예매하기]</router-link>
    <router-link to="/check">[예매내역확인]</router-link>
    <router-view></router-view>
  </div>
</template>


<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
