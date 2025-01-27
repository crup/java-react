import { useEffect, useState } from "react";

export default function Index() {
  const [products, setProducts] = useState<Array<{ id: number; name: string; price: number }>>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    // Fetch products from API (GET)
    const fetchProducts = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/products");

        if (!response.ok) {
          throw new Error(`Failed to fetch products. Status: ${response.status}`);
        }

        const data = await response.json();
        setProducts(data);
      } catch (err) {
        setError(err.message || "Something went wrong.");
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  if (loading) {
    return <p className="text-center text-xl mt-10">Loading...</p>;
  }

  if (error) {
    return <p className="text-center text-red-600 mt-10">Error: {error}</p>;
  }

  return (
    <div className="container mx-auto p-6">
      <h1 className="text-3xl font-bold mb-6 text-center">Product List</h1>

      {products.length > 0 ? (
        <ul className="space-y-4">
          {products.map((product) => (
            <li key={product.id} className="p-4 border rounded-lg shadow-md">
              <div className="flex justify-between items-center">
                <div>
                  <h2 className="text-lg font-semibold">{product.name}</h2>
                  <p className="text-gray-600">Price: ${product.price}</p>
                </div>
              </div>
            </li>
          ))}
        </ul>
      ) : (
        <p className="text-center text-gray-600">No products available.</p>
      )}
    </div>
  );
}
