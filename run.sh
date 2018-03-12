image_name=binbinpku/testweb-alpine
tag=v1.2
docker build -t ${image_name}:${tag} .
imagecount=`docker images|grep ${image_name}|grep ${tag}|wc -l`
echo $imagecount
if [ $imagecount -eq 1 ]; then
  echo "build successfully!"
else
  echo "build failed!!!" 
  exit -1;
fi
docker run -d -p 8080:8080 ${image_name}:${tag}
sleep 5s
container=`curl http://localhost:8080/paas-scenario/|grep age|wc -l`
if [ $container -gt 0 ]; then
  echo "container run succ!!!"
else
  echo "container run failed!!!" 
  exit -1;
fi
docker push ${image_name}:${tag}
