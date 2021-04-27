<template>
  <div class="theaterui">
    <div class="display">
      예매하실 영화를 선택하여 하단의 예매하기 버튼을 눌러주세요
    </div>
  
    <div class="infos" v-for="(movie, run_MOVIE_ID) in movies" :key="run_MOVIE_ID">
      <h3>{{movie.movie_NM}}</h3>
      <div>{{movie.run_MOVIE_ROOM_NUM}}관</div>
      <div>{{movie.run_MOVIE_ROOM_SEATS}}석</div>
      <div>{{movie.run_MOVIE_PRICE}}원</div>
      <div class="sttime">시작시간 : {{movie.run_MOVIE_ST_TIME}}</div>
      <div>총상영시간 : {{movie.run_MOVIE_RUNTIME}}</div>
      <div class="gotoseat">
        <router-link :to="{name: 'SeatChoicePage', params: {run_movie_id: movie.run_MOVIE_ID, roomnum: movie.run_MOVIE_ROOM_NUM}}">
          예매하기
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      current:'',
      movies: this.$axios.get("http://localhost:8770/theater/run_movie").then((res) => {
        console.log(res);
        this.movies = res.data;
        console.log(this.movies);
      })
    };
  },
  methods: {
    sign() {
      this.$axios.get("http://localhost:8770/theater/run_movie").then((res) => {
        console.log(res);
        this.movies = res.data;
        console.log(this.movies);
      });
    },

    insertTest() {
      let info = {
        movie_RESERVATION_ID: 0,
        owner_NM: "박샘물",
        phone_NUM: "010-3949-9284",
        run_MOVIE_ID: 1005,
        seat_NUM: "A-02",
      };
      console.log(info);
      this.$axios
        .post(
          "http://localhost:8770/theater/make_reservation",null,
          {
            params: {
              movie_RESERVATION_ID: 0,
              owner_NM: "박샘물",
              phone_NUM: "010-3949-9284",
              run_MOVIE_ID: 1005,
              seat_NUM: "A-02",
            },
          },
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
        .then((res) => {
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
          throw new Error(error);
        });
    },
    seat() {
      this.$router.push("/seat");
    },
  },
};
</script>

<style scoped>
.theaterui {
  margin: 0 auto;
  align-items: center;
  width: 1200px;
  font-size: 20px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  border: 3px black;
}
.infos{
  border:1px solid skyblue
}

.display {
  grid-column: 1 / 5;
  background-color: black;
  color: white;
}
.top {
  background-color: rgb(195, 241, 241);
}

.btn {
  background-color: mintcream;
  border: 1px solid black;
}
.sttime{
  color: palevioletred;
}
.gotoseat{
  color: black;
  border:blueviolet;
  background-color: peachpuff;
  margin-top: 10px;
}
</style>
