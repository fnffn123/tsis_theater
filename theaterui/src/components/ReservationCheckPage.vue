
<template>
  <div class="theaterui">
    <notifications group="notifyApp" position="top center" />
    <div class="display">
      <h3 >예매내역 조회</h3>
      <form v-on:submit="onSubmitForm"> 
        <!-- v-model input에서 값을 받아올 이름 지정 --> 
        <div>예매내역 조회를 위해 예매자 이름과 휴대폰 번호를 입력해주세요.</div>
        <div>예매자 이름</div>
        <input type="text" v-model="nm"> 
        <div>휴대폰 번호</div>
        <input type="text" v-model="phone">
      </form>
    </div>
    <button @click="getreservation"  class="btm">예매내역확인</button> 
    <div v-for="(seat, i) in seatnum" :key="i" >
        [영화제목]{{movienm[i]}}
        [상영관]{{roomnum[i]}}관
        [시작시간]{{sttime[i]}}
        [좌석]{{seatnum[i]}}

    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      current:null,
      nm:'',
      phone:'',
      movienm:[],
      roomnum:[],
      sttime:[],
      seatnum:[]
    }
  },
  methods: {
    onSubmitForm(e){
        // form의 새로 고침 막기 
        e.preventDefault(); 
        console.log("사용자이름 =" + this.nm); 
        console.log("폰번호 = " + this.phone); 
    },
    getreservation() {
        if(this.nm!=''){
            if(this.phone!=''){
                this.$axios
                .post(
                "http://localhost:8770/theater/get_reservation",null,
                {
                    params: {
                        MOVIE_NM:'',
                        owner_NM: this.nm,
                        phone_NUM: this.phone,
                        run_MOVIE_ID:0,
                        run_MOVIE_ROOM_NUM:0,
                        run_MOVIE_ST_TIME:'',
                        seat_NUM: '',
                    },
                },
                {
                    headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                    },
                }
                )
                .then((res) => {
                    console.log(res.data);
                    for(var d=0;d<res.data.length;++d){
                        this.roomnum.push(res.data[d].run_MOVIE_ROOM_NUM)
                        this.sttime.push(res.data[d].run_MOVIE_ST_TIME)
                        this.seatnum.push(res.data[d].seat_NUM)
                        this.movienm.push(res.data[d].movie_NM)

                    }
                    console.log(this.seatnum)
                    
                    
                })
                .catch((error) => {
                    console.log(error);
                    throw new Error(error);
                });
                this.$notify({
                    group: 'notifyApp',
                    type: 'default',
                    duration:500,
                    title: '조회 완료',
                })

            }

            else{
                this.$notify({
                    group: 'notifyApp',
                    type: 'default',
                    duration:500,
                    title: '휴대폰 번호를 입력해주세요',
                })
            }
        }
        else{
            this.$notify({
                group: 'notifyApp',
                type: 'default',
                duration:500,
                title: '예매자 이름을 입력해주세요',
            })
        }
    }
    
  }
}
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
.bottom{
    margin-top: 100px;

}
</style>
