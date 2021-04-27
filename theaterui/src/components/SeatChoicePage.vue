
<template>
  <div class="theaterui">
    <notifications group="notifyApp" position="top center" />
    <div class="display">
      <div>원하는 좌석을 선택해주세요. 빨간색 좌석은 이미 예약 된 좌석입니다.</div>
      <div>선택 된 좌석 : {{this.seatdata}}</div>
      <button class="btn">
        <router-link :to="{name: 'ReservationPage', params: {run_movie_id: $route.params.run_movie_id, seat:seatdata}}">
          선택완료
        </router-link>
      </button>
    </div>
    <table class="tb">
        <tbody>
          <tr v-for="(i, idx) in row" :key="idx">
            <td v-for="(j, idx) in col" :key="idx" >
              <button  @click="check(apblist[i]+'-'+j, $event)"
                v-bind:id="apblist[i]+'-'+j"
                v-bind:ref="i + j" 
                class="seats">
                {{ apblist[i] }}-{{ j }}
              </button>
            </td>
          </tr>
        </tbody>
      </table>

  </div>
</template>

<script>
export default {
  data(){
    return{
      current:null,
      row:0,
      col:0,
      rowcol:this.$axios
        .get(
          "http://localhost:8770/theater/get_movieroom",
          {
            params: {
              movie_ROOM_NUM:this.$route.params.roomnum,
            },
          },
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
      .then((response) => {
        console.log("야야야야야")
        console.log(response.data[0].movie_ROOM_ROWS)
        this.row=response.data[0].movie_ROOM_ROWS
        this.col=response.data[0].movie_ROOM_COLS
        console.log(this.row)
      })
      .catch(function (error) {
        console.log(error);
      }),
      redseat:[],
      apblist:['','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'],
      seatdata:[],
      
    }
  },
  created(){
    
  },
  async mounted(){
    console.log("마운티드!")
    await this.$axios
        .get(
          "http://localhost:8770/theater/picked_seats",
          {
            params: {
              movie_RESERVATION_ID:0,
              run_MOVIE_ID : this.$route.params.run_movie_id,
              owner_NM:'',
              phone_NUM:'',
              seat_NUM:''
            },
          },
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
      .then(response => {
        console.log(response.data)
        for(var iii=0;iii<response.data.length;++iii){
          this.redseat.push(response.data[iii].seat_NUM)
        }
        console.log(this.redseat)
      })
      .catch(function (error) {
        console.log(error);
      })
    for(var ii=0; ii<this.redseat.length;++ii){
        document.getElementById(this.redseat[ii]).style = "background:red"
    }


  },
  methods: {
    sign(){
      this.$axios.get('http://localhost:8770/theater/run_movie')
      .then(res => {
        console.log(res); 
        this.current = res.data
      });
    },
    check(curseat, event){
      let th=this
        if (event.currentTarget.style.background == "plum") {
          event.currentTarget.style = "background:";
          this.seatdata.pop()

          // let idx = this.selectedSeat.indexOf(seatNum);
          // this.selectSeats.splice(idx, 1);
        } else if(event.currentTarget.style.background != "red"){
          event.currentTarget.style = "background:plum";
          this.seatdata.push(curseat)
        }
      

      console.log(this.curseat)
      let seatflag=0
        for(var i=0;i<th.redseat.length;++i){
          if(curseat == th.redseat[i]){
            console.log("중복")
            this.$notify({
              group: 'notifyApp',
              type: 'default',
              duration:500,
              title: '이미 선택 된 좌석입니다.',
              text: '다른 좌석을 선택해주세요.'
            })
            seatflag=1;
          }
        }
        if(seatflag==1){
          this.seatdata.pop()
        }
          
    },
    getRoom(){
      this.$axios
        .get(
          "http://localhost:8770/theater/get_movieroom",
          {
            params: {
              movie_ROOM_NUM:this.$route.params.roomnum,
            },
          },
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
      .then(function (response) {
        console.log(response.data)
        this.row=response.data.movie_ROOM_ROWS
        this.col=response.data.movie_ROOM_COLS
      })
      .catch(function (error) {
        console.log(error);
      });
    }
  }
}
//array1.find(element => element > 10);
</script>

<style scoped>
.theaterui{
  margin: 0 auto;
  align-items: center;
  width: 1200px;
  font-size: 25px;
  border: 3px black;
}
.tb{
  margin: auto;
  width: 80%;
}

.display{
  grid-column: 1 / 5;
  color: plum;
}
.top{
  background-color: rgb(195, 241, 241);
}

.btn{
  background-color: mintcream;
  border: 1px solid black;
  margin: 10px;
}
.infos{
  grid-template-rows: repeat(300,50fr);
}
.oneseat{
  color: blueviolet;
}
.seats{
  background-color: aliceblue;
  width: 50px;
  height: 40px;
}

</style>
