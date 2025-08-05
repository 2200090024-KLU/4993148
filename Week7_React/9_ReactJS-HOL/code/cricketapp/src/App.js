import logo from './logo.svg';
import './App.css';
import {LessScore, ListofPlayers} from "./ListofPlayers";

const players =[{name:"Jack",score:50},{name:"Dhoni",score:70},{name:"Virat",score:80},{name:"Elisabeth",score:50},{name:"Ann",score:30},{name:"Jadeja",score:70}]
const indianPlayers = [{name:"Sachin",score:14},{name:"Virat",score:18},{name:"Dhoni",score:7},{name:"Rohit",score:45},{name:"Jadeja",score:9}]
const ranhjiPlayers = ['firstPlayer','secondPlayer','thirdPlayer']
const ttPlayers = ['fourthPlayer','fifthPlayer','sixthPlayer']
const merged = [...ranhjiPlayers,...ttPlayers]


function OddPlayers (player){
    return (
        player.map((item)=>{
            if(item.score %2 !==0){
                return (
                    <div style={{padding: "15px"}}>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                )
            }
        })
    )
}
function EvenPlayers (player){
    return (
        player.map((item)=>{
            if(item.score %2 ===0){
                return (
                    <div style={{padding: "15px"}}>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                )
            }
        })
    )
}

function ListOfIndianPlayers (player){
    return (
        player.map((item)=>{

                return (
                    <div style={{padding: "15px"}}>
                        <li>{item}</li>
                    </div>
                )

        })
    )
}

function App() {
    var flag = true
  if (flag === true){
    return(
        <div style={{padding: "15px"}}>
            <h1>List Of Players</h1>
            <ListofPlayers players={players}/>
            <h1>List Of Players</h1>
            <LessScore players={players}/>
        </div>

    )
  }
  else {
      return (
          <div style={{padding: "15px"}}>
              <h1>Indian Players</h1>
              <h2>Odd Players</h2>
              {OddPlayers(indianPlayers)}
              <h2>Even Players</h2>
              {EvenPlayers(indianPlayers)}
              <h2>List of Indian Players Merged</h2>
              {ListOfIndianPlayers(merged)}
          </div>
      )

  }
}

export default App;
