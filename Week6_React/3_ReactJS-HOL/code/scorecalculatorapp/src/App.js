import logo from './logo.svg';
import './App.css';
import {CalculateScore, Calculator} from "./Components/CalculateScore";

function App() {
  return (
    <div className="App">
      <CalculateScore Name={"Steeve"} goal={3} total={284} School={"DNV Public School"} />
    </div>
  );
}

export default App;
