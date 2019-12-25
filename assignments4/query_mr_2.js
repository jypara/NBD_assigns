var m = function() {
	for(var i=0;i<this.credit.length;i++)
emit(this.credit[i].currency, this.credit[i].balance);
};
var r = function(k, val) {
return Array.sum(val);
};
var options = {out: "total_balance" };
db.people.mapReduce(m,r,options)
printjson(db.total_balance.find({}).toArray())
