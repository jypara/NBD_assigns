var m = function() {
emit(this.sex, { sumH:this.height, sumW:this.weight,count:1});
};
var r = function(k, val) {
reducedVal = { sumH: 0, sumW: 0 , count:0};
for (var i = 0; i < val.length; i++) {
                         reducedVal.sumH +=val[i].sumH;
                         reducedVal.sumW+= val[i].sumW;
reducedVal.count +=val[i].count; }
  
return reducedVal;
};
function finalize(key, v) {
   return {
     avgHeight: v.sumH/ v.count,
     avgWeight: v.sumW/ v.count
   };
}
var options = {out: "avg_height_and_weight", finalize : finalize };
db.people.mapReduce(m,r,options)
printjson(db.avg_height_and_weight.find({}).toArray())
