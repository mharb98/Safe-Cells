validmove([X,Y],Available,Needed):-dim(DIM1,DIM2),
	Needed =< Available,
	X >= 0,
    X =< DIM1-1,
    Y >= 0,
    Y =< DIM2-1,
	\+corona([X,Y]).
	
move([X1,Y1],Available,[X2,Y1],NewAvailable):-X2 is X1+1,
	downcost(Needed),
	validmove([X2,Y1],Available,Needed),
	NewAvailable is Available-Needed.
	
move([X1,Y1],Available,[X2,Y1],NewAvailable):-X2 is X1-1,
	upcost(Needed),
	validmove([X2,Y1],Available,Needed),
	NewAvailable is Available-Needed.
	
move([X1,Y1],Available,[X1,Y2],NewAvailable):-Y2 is Y1-1,
	leftcost(Needed),
	validmove([X1,Y2],Available,Needed),
	NewAvailable is Available-Needed.
	
move([X1,Y1],Available,[X1,Y2],NewAvailable):-Y2 is Y1+1,
	rightcost(Needed),
	validmove([X1,Y2],Available,Needed),
	NewAvailable is Available-Needed.
	
moves(State,Available,Open,Visited,NewState,NewAvailable):-move(State,Available,NewState,NewAvailable),
	\+member(NewState,Open),
	\+member(NewState,Visited).
	
getmoves(State,Available,Open,Visited,NewState,NewAvailable):-findall(NS,moves(State,Available,Open,Visited,NS,NA),NewState),
	findall(NA,moves(State,Available,Open,Visited,NS,NA),NewAvailable).

dfs([],_,Visited,Visited).

dfs([State|Open],[Cost|Available],Visited,R):-getmoves(State,Cost,Open,Visited,NS,NA),
	length(NS,N),
	N =:= 0,
	dfs(Open,Available,[State|Visited],R).
	
dfs([State|Open],[Cost|Available],Visited,R):-getmoves(State,Cost,Open,Visited,NS,NA),
	length(NS,N),
	N > 0,
	append(NS,Open,NewOpen),
	append(NA,Available,NewAvailable),
	dfs(NewOpen,NewAvailable,[State|Visited],R).

parse([H|T],T).

spongebob(S):-start(St),
	cost(C),
	dfs([St],[C],[],R),
	reverse(R,R2),
	parse(R2,S).




