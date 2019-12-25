var m = function() {
emit(this.sex, { H:[this.height], W:[this.weight],count:1});
};
 var r = function(k, val) {
reducedVal = { H:[] ,W:[] , count:0};
for (var i = 0; i < val.length; i++) {
              reducedVal.H=val[i].H.concat(reducedVal.H);
              reducedVal.W=val[i].W.concat(reducedVal.W);
reducedVal.count +=val[i].count; }
  return reducedVal;
};
function finalize(key, v) {
var sumBMI=0,minBMI = v.W[0] /v.H[0] /v.H[0]*10000 ,maxBMI= minBMI;
for (var i = 0; i < v.W.length; i++){
BMI=v.W[i] /v.H[i] /v.H[i]*10000;
minBMI=BMI< minBMI?BMI: minBMI
maxBMI =BMI> maxBMI?BMI: maxBMI
sumBMI+=BMI
}
   return {avgBMI:sumBMI/v.count, minBMI: minBMI , maxBMI : maxBMI };
   };
db.people.mapReduce(m,r, {  out:"BMI", finalize : finalize })
printjson(db.BMI.find().toArray())

