import { Link } from "react-router-dom";

export default function NavBar() {
  return (
    <nav className="w-100 d-flex flex-row justify-content-between align-items-center p-2">
        <div className="d-flex flex-row justify-content-between align-items-center gap-2">
            <button className="btn btn-info ">
                <Link to={"/"} className="text-white text-decoration-none">
                    <span>Catalog</span>
                </Link>
            </button>
            <button className="btn btn-primary ">
                <Link to={"/book/create"} className="text-white text-decoration-none">
                    <span>Add Book</span>
                </Link>
            </button>
        </div>
        <h1>
            Book Catalog
        </h1>
    </nav>
  )
}
