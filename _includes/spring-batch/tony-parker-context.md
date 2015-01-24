## Context

Let's say we provide ours customers with consolidated NBA players statistics. Our staple food is statistics 
like those of the 2013-14 season of Tony Parker.

Player | Season | GP | MIN | FGM | FGA | FG% | 3FGM | 3FGA | 3FG% | FTM | FTA | FT%
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
Tony Parker | 2013-14 | 68 | 29.4 | 6.7 | 13.4 | 49.9% | 0.4 | 1.0 | 37.3% | 2.9 | 3.6 | 81.1%  



OREB | DREB | REB | AST | TOV | STL | BLK | PF | DD2 | TD3 | PTS
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
0.3 | 2.0 | 2.3 | 5.7 | 2.2 | 0.5 | 0.1 | 1.3 | 2 | 0 | 16.7

which gives us the flowing line in a delimited flat file :

	Tony Parker,2013-14,68,29.4,6.7,13.4,49.9%,0.4,1.0,37.3%,2.9,3.6,81.1%,0.3,2.0,2.3,5.7,2.2,0.5,0.1,1.3,2,0,16.7
