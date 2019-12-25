var m = function() {
if(this.sex!="Female")
return
for(var i=0;i<this.credit.length;i++)
emit(this.credit[i].currency, {bal:this.credit[i].balance,count:1});
};
var r = function(k, val) {
var reducedVal={bal:0,count:0}
val.forEach(val=>{
reducedVal.count+=val.count;
 reducedVal.bal+=val.bal;})
return reducedVal;
};

function finalize(key, v) {
return {totalBalance: v.bal, avgBalance: v.bal /v.count};
}
var options = {out: "avg_and_total_balance", finalize : finalize };
db.people.mapReduce(m,r,options)
printjson(db.avg_and_total_balance.find({}).toArray())
