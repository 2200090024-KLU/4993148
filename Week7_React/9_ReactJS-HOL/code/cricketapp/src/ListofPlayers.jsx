export const ListofPlayers= ({players})=>{
    return(
        players.map((item)=>{
            return(
                <div>
                    <li>Mr. {item.name} <span>{item.score}</span></li>
                </div>
            )
        })
    )
}

export const LessScore= ({players})=>{
    return(
        players.map((item)=>{
            if (item.score < 70){
                return(
                    <div>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                )
            }
        })
    )
}

