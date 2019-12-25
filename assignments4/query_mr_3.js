var m = function() {
emit(this.job,1);
};
    var r = function(k, v) {
return null;
};
    var options = {
  out:"job_list" 
};
db.people.mapReduce(m,r,options)
printjson(db.job_list.find({},{id:1}).toArray())
