using Vehiclecfg_group9.DTO;

namespace Vehiclecfg_group9.Services
{
    public interface IInvoiceService
    {
        Task<IEnumerable<InvoiceResponseDto>> GetAllInvoicesAsync();

        Task<InvoiceResponseDto?> GetInvoiceByIdAsync(long invoiceId);

        Task<InvoiceResponseDto> AddInvoiceAsync(
            InvoiceCreateDto invoiceDto);

        Task<InvoiceResponseDto?> UpdateInvoiceAsync(
            long invoiceId,
            InvoiceCreateDto invoiceDto);

        Task<bool> DeleteInvoiceAsync(long invoiceId);
    }
}