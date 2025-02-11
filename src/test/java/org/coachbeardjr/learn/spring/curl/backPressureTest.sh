req=200
URL="http://localhost:8080/users/stream"
for i in $(seq 1 $req)
do
  curl "$URL" &
done

sleep 5
echo "all requests done"